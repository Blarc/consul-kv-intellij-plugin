package com.github.blarc.consul.kv.intellij.plugin

import com.intellij.openapi.components.Service

// TODO: Is Level.Project OK?
@Service(Service.Level.PROJECT)
class ConsulKVService {
    fun getRandomNumber() = (1..100).random()
}
