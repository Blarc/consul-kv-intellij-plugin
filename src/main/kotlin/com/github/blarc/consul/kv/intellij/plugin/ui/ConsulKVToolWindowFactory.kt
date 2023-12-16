package com.github.blarc.consul.kv.intellij.plugin.ui

import ConsulKVBundle
import com.github.blarc.consul.kv.intellij.plugin.ConsulKVService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import javax.swing.JButton

/**
 * The main Consul KV tool window on right panel.
 */
class ConsulKVToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        // TODO: Add actions
        // toolWindow.setAdditionalGearActions()

        val myToolWindow = ConsulKVToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)

    }

    override fun shouldBeAvailable(project: Project) = true

    class ConsulKVToolWindow(toolWindow: ToolWindow) {

        // We can get project via toolWindow.project
       private val service = toolWindow.project.service<ConsulKVService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            val label = JBLabel(ConsulKVBundle.message("randomLabel", "?"))

            add(label)
            add(JButton(ConsulKVBundle.message("shuffle")).apply {
                addActionListener {
                    label.text = ConsulKVBundle.message("randomLabel", service.getRandomNumber())
                }
            })
        }
    }


}
