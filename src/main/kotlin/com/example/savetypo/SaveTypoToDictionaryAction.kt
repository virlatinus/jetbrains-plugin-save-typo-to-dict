package com.example.savetypo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.spellchecker.SpellCheckerManager

class SaveTypoToDictionaryAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val project = e.project ?: return

        // Get the caret and the word around it
        val caretModel = editor.caretModel
        val offset = caretModel.offset
        val document = editor.document
        val text = document.charsSequence

        // Find word boundaries (simple heuristic, can be improved using SpellChecker's lexer if needed)
        var start = offset
        while (start > 0 && Character.isLetterOrDigit(text[start - 1])) {
            start--
        }

        var end = offset
        while (end < text.length && Character.isLetterOrDigit(text[end])) {
            end++
        }

        if (start < end) {
            val word = text.subSequence(start, end).toString()

            // Add the word to the project-level dictionary
            SpellCheckerManager.getInstance(project).acceptWordAsCorrect(word, project)
        }
    }

    override fun update(e: AnActionEvent) {
        // Action is only visible/enabled if we have a project and an editor
        val project = e.project
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabledAndVisible = project != null && editor != null
    }
}
