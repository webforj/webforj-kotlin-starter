package com.webforjkotlinstarter.components

import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexDirection
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.dsl.component.html.elements.h1
import com.webforj.kotlin.dsl.component.html.elements.paragraph
import com.webforj.kotlin.extension.styles
import com.webforj.kotlin.extension.set
import com.webforj.kotlin.extension.px
import com.webforj.kotlin.extension.em

class DrawerHeader : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.setDirection(FlexDirection.COLUMN)
    self.setSpacing(0.px)

    self.h1("Mailbox") {
      styles["margin-bottom"] = "0"
    }

    self.paragraph("john@mailbox.com") {
      styles["color"] = "#86888f"
      styles["font-size"] = 0.7.em
    }
  }
}
