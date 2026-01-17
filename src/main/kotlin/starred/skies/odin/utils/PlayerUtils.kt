package starred.skies.odin.utils

import com.odtheking.odin.OdinMod.mc
import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping

fun rightClick() {
    val key = mc.options.keyUse
    KeyMapping.click(key.boundKey())
}

fun leftClick() {
    val key = mc.options.keyAttack
    KeyMapping.click(key.boundKey())
}

private val keyField by lazy {
    KeyMapping::class.java.getDeclaredField("key").apply { isAccessible = true }
}

private fun KeyMapping.boundKey(): InputConstants.Key =
    keyField.get(this) as InputConstants.Key
