package ml.ikwid.banharmingtwoarrows.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.TippedArrowRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Avoid loading a recipe to craft tipped arrows of Harming 2
 */
@Mixin(TippedArrowRecipe.class)
public class MixinTippedArrowRecipe {
    @Redirect(method = "matches(Lnet/minecraft/inventory/CraftingInventory;Lnet/minecraft/world/World;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    private boolean addFilter(ItemStack instance, Item item) {
        return instance.isOf(item) && !(instance.getItem().getTranslationKey(instance).contains("harming") && PotionUtil.getPotionEffects(instance).get(0).getAmplifier() > 0); // original, then checks if potion is NOT harming and does NOT have amplifier > 0 (which means harming 2 i think)
    }
}
