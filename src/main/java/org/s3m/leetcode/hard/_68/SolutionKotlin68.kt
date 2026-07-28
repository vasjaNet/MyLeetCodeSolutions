package org.s3m.leetcode.hard._68

import kotlin.math.max

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    val tempLine = mutableListOf<String>()
    var curentLength = 0
    for(i in 0 until words.size) {
        if(curentLength + words[i].length + tempLine.size > maxWidth) {
            result.add(justifyLine(tempLine, maxWidth, curentLength, false))
            tempLine.clear()
            curentLength = 0
        }
        tempLine.add(words[i])
        curentLength += words[i].length
    }
    result.add(justifyLine(tempLine, maxWidth, curentLength, true))
    return result
}

fun justifyLine(words: List<String>, maxWidth: Int, curentLength: Int, isLastLine: Boolean): String {
    val wordCount = words.size
    val spaceCount = maxWidth - curentLength
    var evenSpaceCount = if(wordCount == 1)  spaceCount else spaceCount / (wordCount-1)
    var extraSpaceCount = if(wordCount == 1)  0 else spaceCount % (wordCount-1)
    if (isLastLine) {
        evenSpaceCount = 1
        extraSpaceCount = 0
    }
    val justifiedLine = StringBuilder()
    for(i in 0 until wordCount) {
        justifiedLine.append(words[i])
        if(i < wordCount-1) {
            justifiedLine.append(" ".repeat(max(0, evenSpaceCount)))
            if(extraSpaceCount > 0) {
                justifiedLine.append(' ')
                extraSpaceCount--;
            }
        }
    }
    if(isLastLine || wordCount == 1) {
        justifiedLine.append(" ".repeat(max(0, spaceCount - (wordCount-1))))
    }
    return justifiedLine.toString()
}

