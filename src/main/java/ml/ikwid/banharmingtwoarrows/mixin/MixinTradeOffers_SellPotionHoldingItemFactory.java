package ml.ikwid.banharmingtwoarrows.mixin;

import net.minecraft.potion.Potion;
import net.minecraft.village.TradeOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Avoid allowing Fletchers to sell Tipped Arrows of Harming 2
 */
@Mixin(TradeOffers.SellPotionHoldingItemFactory.class)
public class MixinTradeOffers_SellPotionHoldingItemFactory {
    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;"))
    private <T> Stream<T> addFilter(Stream<T> instance, Predicate<T> predicate) { // T is of type Potion
        return instance.filter(predicate.and((Predicate<? super T>) (potionx) -> !((Potion)potionx).finishTranslationKey("").contains("strong_harming"))); // original, then checks if potion is NOT harming and does NOT have amplifier > 0 (which means harming 2 i think)")));
    }
}
