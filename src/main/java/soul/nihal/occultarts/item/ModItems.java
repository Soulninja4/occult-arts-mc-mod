package soul.nihal.occultarts.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import soul.nihal.occultarts.OccultArts;
import soul.nihal.occultarts.item.custom.CrudeDaggerItem;

public class ModItems {
  public static final Item BLOOD_DROP = registerItem("blood_drop",
      new Item(new FabricItemSettings()));
  public static final Item CRUDE_DAGGER = registerItem("crude_dagger",
      new CrudeDaggerItem(ToolMaterials.STONE, 1, -2.4F,
          new FabricItemSettings()));
  public static final Item RITUAL_DAGGER = registerItem("ritual_dagger",
      new SwordItem(ToolMaterials.STONE, 1, -2.4F,
          new FabricItemSettings()));

  public static void addItemsToItemsGroup() {
    addToItemGroup(ItemGroups.INGREDIENTS, BLOOD_DROP);
    addToItemGroup(ItemGroups.COMBAT, CRUDE_DAGGER);
    addToItemGroup(ItemGroups.COMBAT, RITUAL_DAGGER);

    addToItemGroup(ModItemGroup.OCCULT, BLOOD_DROP);
    addToItemGroup(ModItemGroup.OCCULT, CRUDE_DAGGER);
    addToItemGroup(ModItemGroup.OCCULT, RITUAL_DAGGER);
  }

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(OccultArts.MOD_ID, name), item);
  }

  private static void addToItemGroup(ItemGroup group, Item item) {
    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
  }

  public static void registerModItems() {
    OccultArts.LOGGER.info("Registering Mod Items for " + OccultArts.MOD_ID);
    addItemsToItemsGroup();
  }

}
