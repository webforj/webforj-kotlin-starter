package com.webforjkotlinstarter.components

import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexAlignment
import com.webforj.component.layout.flexlayout.FlexDirection
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.dsl.component.html.elements.anchor
import com.webforj.kotlin.dsl.component.html.elements.h3
import com.webforj.kotlin.dsl.component.html.elements.img
import com.webforj.kotlin.extension.styles
import com.webforj.kotlin.extension.set
import com.webforj.kotlin.extension.em
import com.webforj.kotlin.extension.px

class Explore(title: String) : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.addClassName("explore-component")
    self.styles["margin"] = "${1.em} auto"
    self.setDirection(FlexDirection.COLUMN)
    self.setAlignment(FlexAlignment.CENTER)
    self.setMaxWidth(300.px)
    self.setSpacing(0.3.em)

    self.img("ws://explore/$title.svg", "mailbox") {
      setMaxWidth(250.px)
    }

    self.h3(title)

    self.anchor("https://docs.webforj.com/docs/components/overview", "Explore UI Components") {
      setTarget("_blank")
    }
  }
}
