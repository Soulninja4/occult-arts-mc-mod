package soul.nihal.occultarts.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import soul.nihal.occultarts.item.ModItems;

public class ModLootTableModifiers {
  private static final Identifier SHEEP_ID = new Identifier("minecraft", "entities/sheep");

  private static final Identifier GOAT_ID = new Identifier("minecraft", "entities/goat");

  public static void modifyLootTables() {
    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
      if (SHEEP_ID.equals(id) || GOAT_ID.equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
            .rolls(ConstantLootNumberProvider.create(1))
            .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                    .mainhand(ItemPredicate.Builder.create().items(ModItems.RITUAL_DAGGER).build()).build()).build()))
            .conditionally(RandomChanceLootCondition.builder(1f))
            .with(ItemEntry.builder(ModItems.BLOOD_DROP))
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
        tableBuilder.pool(poolBuilder.build());
      }
    });
  }

}
