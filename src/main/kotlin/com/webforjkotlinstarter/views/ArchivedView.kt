package com.webforjkotlinstarter.views

import com.webforjkotlinstarter.components.Explore
import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexAlignment
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.extension.percent
import com.webforj.router.annotation.FrameTitle
import com.webforj.router.annotation.Route

@Route(value = "/archived", outlet = MainLayout::class)
@FrameTitle("Archived")
class ArchivedView : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.setHeight(100.percent)
    self.setAlignment(FlexAlignment.CENTER)
    self.add(Explore("Archived"))
  }
}
