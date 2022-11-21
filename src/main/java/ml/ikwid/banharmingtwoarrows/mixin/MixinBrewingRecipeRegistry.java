package ml.ikwid.banharmingtwoarrows.mixin;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class MixinBrewingRecipeRegistry {
    @Inject(method = "registerPotionRecipe", at = @At("HEAD"), cancellable = true)
    private static void addFilter(Potion input, Item item, Potion output, CallbackInfo ci) {
        if (output == Potions.STRONG_STRENGTH) {
            ci.cancel();
        }
    }
}
