package soul.nihal.occultarts.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import soul.nihal.occultarts.OccultArts;

public class ModItems {
  public static final Item BLOOD_DROP = registerItem("blood_drop",
      new Item(new FabricItemSettings()));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(OccultArts.MOD_ID, name), item);
  }

  public static void addItemsToItemsGroup() {
    addToItemGroup(ItemGroups.INGREDIENTS, BLOOD_DROP);
  }

  private static void addToItemGroup(ItemGroup group, Item item) {
    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
  }

  public static void registerModItems() {
    OccultArts.LOGGER.info("Registering Mod Items for" + OccultArts.MOD_ID);
    addItemsToItemsGroup();
  }
}
