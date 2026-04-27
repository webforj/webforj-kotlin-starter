package com.webforjkotlinstarter.views

import com.webforjkotlinstarter.components.DrawerHeader
import com.webforjkotlinstarter.components.ThemeToggle
import com.webforjkotlinstarter.components.UserBadge
import com.webforj.component.Composite
import com.webforj.component.Theme
import com.webforj.component.html.elements.H1
import com.webforj.component.icons.IconButton
import com.webforj.component.icons.TablerIcon
import com.webforj.component.layout.applayout.AppLayout
import com.webforj.component.toast.Toast
import com.webforj.concern.HasComponents
import com.webforj.dispatcher.ListenerRegistration
import com.webforj.kotlin.dsl.component.html.elements.h1
import com.webforj.kotlin.dsl.component.icons.iconButton
import com.webforj.kotlin.dsl.component.layout.applayout.appDrawerToggle
import com.webforj.kotlin.dsl.component.layout.applayout.drawerFooterSlot
import com.webforj.kotlin.dsl.component.layout.applayout.drawerSlot
import com.webforj.kotlin.dsl.component.layout.applayout.drawerTitleSlot
import com.webforj.kotlin.dsl.component.layout.applayout.headerSlot
import com.webforj.kotlin.dsl.component.layout.appnav.appNav
import com.webforj.kotlin.dsl.component.layout.appnav.appNavItem
import com.webforj.kotlin.dsl.component.toolbar.endSlot
import com.webforj.kotlin.dsl.component.toolbar.startSlot
import com.webforj.kotlin.dsl.component.toolbar.titleSlot
import com.webforj.kotlin.dsl.component.toolbar.toolbar
import com.webforj.kotlin.extension.prefixSlot
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
    self.apply {
      isDrawerHeaderVisible = true
      isDrawerFooterVisible = true

      drawerTitleSlot {
        add(DrawerHeader())
      }

      headerSlot {
        toolbar {
          startSlot {
            appDrawerToggle(TablerIcon.create("layout-sidebar"))
          }
          titleSlot {
            title = h1()
          }
          endSlot {
            buildToolbarButton("search", "Search")
            buildToolbarButton("bell", "Notifications")
            add(ThemeToggle())
            add(UserBadge("John Doe", "Admin"))
          }
        }
      }

      drawerSlot {
        appNav {
          appNavItem("Dashboard", view = DashboardView::class) {
            prefixSlot { TablerIcon.create("layout-dashboard") }
          }
          appNavItem("Contacts", view = ContactsView::class) {
            prefixSlot { TablerIcon.create("users") }
          }
          appNavItem("Deals", view = DealsView::class) {
            prefixSlot { TablerIcon.create("briefcase") }
          }
          appNavItem("Tasks", view = TasksView::class) {
            prefixSlot { TablerIcon.create("checklist") }
          }
          appNavItem("Calendar", view = CalendarView::class) {
            prefixSlot { TablerIcon.create("calendar-event") }
          }
          appNavItem("Reports", view = ReportsView::class) {
            prefixSlot { TablerIcon.create("chart-bar") }
          }
        }
      }

      drawerFooterSlot {
        buildToolbarButton("logout", "Logout")
      }
    }

    navigateRegistration = Router.getCurrent().onNavigate(this::onNavigate)
  }

  private fun HasComponents.buildToolbarButton(iconName: String, label: String): IconButton =
    iconButton(TablerIcon.create(iconName)) {
      onClick {
        Toast.show("\"$label\" is not wired up yet", 3000, Theme.INFO, Toast.Placement.BOTTOM_RIGHT)
      }
    }

  override fun onDidDestroy() {
    navigateRegistration?.remove()
  }

  private fun onNavigate(ev: NavigateEvent) {
    val view = ev.context.allComponents.firstOrNull { it.javaClass.simpleName.endsWith("View") }
    if (view != null) {
      val frameTitle = view.javaClass.getAnnotation(FrameTitle::class.java)
      title.text = frameTitle?.value ?: ""
    }
  }
}
