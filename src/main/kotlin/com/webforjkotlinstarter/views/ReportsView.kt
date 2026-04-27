package com.webforjkotlinstarter.views

import com.webforjkotlinstarter.components.Explore
import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexAlignment
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.extension.percent
import com.webforj.router.annotation.FrameTitle
import com.webforj.router.annotation.Route

@Route(value = "/reports", outlet = MainLayout::class)
@FrameTitle("Reports")
class ReportsView : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.apply {
      height = 100.percent
      alignment = FlexAlignment.CENTER
      add(Explore("No reports yet", "chart-bar", "Build report"))
    }
  }
}
