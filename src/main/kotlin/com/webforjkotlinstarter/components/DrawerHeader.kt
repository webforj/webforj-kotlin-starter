package com.webforjkotlinstarter.components

import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexDirection
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.dsl.component.html.elements.h1
import com.webforj.kotlin.dsl.component.html.elements.paragraph
import com.webforj.kotlin.extension.set
import com.webforj.kotlin.extension.styles

class DrawerHeader : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.apply {
      direction = FlexDirection.COLUMN
      spacing = "0"

      h1("Acme CRM") {
        styles["margin"] = "0"
      }

      paragraph("john@acme.com") {
        styles["color"] = "var(--dwc-color-gray-text-light)"
        styles["font-size"] = "var(--dwc-font-size-xs)"
        styles["margin"] = "0"
      }
    }
  }
}
