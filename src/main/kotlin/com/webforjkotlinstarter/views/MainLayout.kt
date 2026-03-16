package com.webforjkotlinstarter.views

import com.webforjkotlinstarter.components.DrawerHeader
import com.webforj.component.Component
import com.webforj.component.Composite
import com.webforj.component.html.elements.H1
import com.webforj.component.icons.TablerIcon
import com.webforj.component.layout.applayout.AppLayout
import com.webforj.dispatcher.ListenerRegistration
import com.webforj.kotlin.dsl.component.layout.applayout.drawerSlot
import com.webforj.kotlin.dsl.component.layout.applayout.drawerTitleSlot
import com.webforj.kotlin.dsl.component.layout.applayout.headerSlot
import com.webforj.kotlin.dsl.component.layout.appnav.appNav
import com.webforj.kotlin.dsl.component.layout.appnav.appNavItem
import com.webforj.kotlin.extension.prefixSlot
import com.webforj.kotlin.dsl.component.toolbar.startSlot
import com.webforj.kotlin.dsl.component.toolbar.titleSlot
import com.webforj.kotlin.dsl.component.toolbar.toolbar
import com.webforj.kotlin.dsl.component.layout.applayout.appDrawerToggle
import com.webforj.kotlin.dsl.component.html.elements.h1
import com.webforj.kotlin.dsl.init
import com.webforj.router.Router
import com.webforj.router.annotation.FrameTitle
import com.webforj.router.annotation.Route
import com.webforj.router.event.NavigateEvent

@Route
class MainLayout : Composite<AppLayout>() {
  private val self = boundComponent
  private lateinit var title: H1
  private var navigateRegistration: ListenerRegistration<NavigateEvent>? = null

  init {
    setHeader()
    setDrawer()
    navigateRegistration = Router.getCurrent().onNavigate(this::onNavigate)
  }

  private fun setHeader() {
    self.setDrawerHeaderVisible(true)

    self.drawerTitleSlot {
      add(DrawerHeader())
    }

    self.headerSlot {
      toolbar {
        startSlot {
          appDrawerToggle()
        }
        titleSlot {
          title = h1()
        }
      }
    }
  }

  private fun setDrawer() {
    self.drawerSlot {
      appNav {
        appNavItem("Inbox", view = InboxView::class) {
          prefixSlot { TablerIcon.create("inbox") }
        }
        appNavItem("Outbox", view = OutboxView::class) {
          prefixSlot { TablerIcon.create("send-2") }
        }
        appNavItem("Favorites", view = FavoritesView::class) {
          prefixSlot { TablerIcon.create("heart") }
        }
        appNavItem("Archived", view = ArchivedView::class) {
          prefixSlot { TablerIcon.create("archive") }
        }
        appNavItem("Trash", view = TrashView::class) {
          prefixSlot { TablerIcon.create("trash") }
        }
        appNavItem("Spam", view = SpamView::class) {
          prefixSlot { TablerIcon.create("alert-hexagon") }
        }
      }
    }
  }

  override fun onDidDestroy() {
    navigateRegistration?.remove()
  }

  private fun onNavigate(ev: NavigateEvent) {
    val components = ev.context.allComponents
    val view = components.firstOrNull { it.javaClass.simpleName.endsWith("View") }

    if (view != null) {
      val frameTitle = view.javaClass.getAnnotation(FrameTitle::class.java)
      title.setText(frameTitle?.value ?: "")
    }
  }
}
