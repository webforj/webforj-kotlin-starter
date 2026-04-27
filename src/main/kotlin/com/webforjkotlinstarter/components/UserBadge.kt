package com.webforjkotlinstarter.components

import com.webforj.component.Composite
import com.webforj.component.layout.flexlayout.FlexAlignment
import com.webforj.component.layout.flexlayout.FlexDirection
import com.webforj.component.layout.flexlayout.FlexLayout
import com.webforj.kotlin.dsl.component.avatar.avatar
import com.webforj.kotlin.dsl.component.html.elements.span
import com.webforj.kotlin.dsl.component.layout.flexlayout.flexLayout
import com.webforj.kotlin.extension.em
import com.webforj.kotlin.extension.set
import com.webforj.kotlin.extension.styles

class UserBadge(name: String, role: String) : Composite<FlexLayout>() {
  private val self = boundComponent

  init {
    self.apply {
      alignment = FlexAlignment.CENTER
      spacing = 0.5.em
      styles["padding-left"] = "var(--dwc-space-m)"
      styles["background-image"] =
        "linear-gradient(to bottom, transparent, var(--dwc-border-color) 20%, var(--dwc-border-color) 80%, transparent)"
      styles["background-repeat"] = "no-repeat"
      styles["background-position"] = "left"
      styles["background-size"] = "1px 100%"

      flexLayout(FlexDirection.COLUMN) {
        spacing = "0"

        span(name) {
          styles["font-size"] = "var(--dwc-font-size-s)"
          styles["font-weight"] = "var(--dwc-font-weight-medium)"
          styles["line-height"] = "1.2"
        }

        span(role) {
          styles["font-size"] = "var(--dwc-font-size-xs)"
          styles["color"] = "var(--dwc-color-gray-text-light)"
          styles["line-height"] = "1.2"
        }
      }

      avatar(name)
    }
  }
}
