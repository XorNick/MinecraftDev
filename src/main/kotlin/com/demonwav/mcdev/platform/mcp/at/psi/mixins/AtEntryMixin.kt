/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2017 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.platform.mcp.at.psi.mixins

import com.demonwav.mcdev.platform.mcp.at.AtElementFactory
import com.demonwav.mcdev.platform.mcp.at.gen.psi.AtAsterisk
import com.demonwav.mcdev.platform.mcp.at.gen.psi.AtClassName
import com.demonwav.mcdev.platform.mcp.at.gen.psi.AtFieldName
import com.demonwav.mcdev.platform.mcp.at.gen.psi.AtFunction
import com.demonwav.mcdev.platform.mcp.at.gen.psi.AtKeyword
import com.intellij.psi.PsiElement

interface AtEntryMixin : PsiElement {

    val asterisk: AtAsterisk?
    val className: AtClassName
    val fieldName: AtFieldName?
    val function: AtFunction?
    val keyword: AtKeyword

    fun setEntry(entry: String)
    fun setKeyword(keyword: AtElementFactory.Keyword)
    fun setClassName(className: String)
    fun setFieldName(fieldName: String)
    fun setFunction(function: String)
    fun setAsterisk()
}
