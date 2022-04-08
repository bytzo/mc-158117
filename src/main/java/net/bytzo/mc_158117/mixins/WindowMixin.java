package net.bytzo.mc_158117.mixins;

import com.mojang.blaze3d.platform.Window;

import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WindowMixin {
	@Inject(
			method = "<init>",
			at = @At(
					value = "INVOKE",
					target = "Lorg/lwjgl/glfw/GLFW;glfwCreateWindow(IILjava/lang/CharSequence;JJ)J",
					remap = false
			)
	)
	private void disableGlfwAutoIconify(CallbackInfo callbackInfo) {
		GLFW.glfwWindowHint(GLFW.GLFW_AUTO_ICONIFY, GLFW.GLFW_FALSE);
	}
}
