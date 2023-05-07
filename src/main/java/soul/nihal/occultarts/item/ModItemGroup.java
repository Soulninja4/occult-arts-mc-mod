package soul.nihal.occultarts.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import soul.nihal.occultarts.OccultArts;

public class ModItemGroup {
  public static ItemGroup OCCULT;

  public static void registerItemGroups() {
    OCCULT = FabricItemGroup.builder(new Identifier(OccultArts.MOD_ID, "occult"))
        .displayName(Text.translatable("itemgroup.occult"))
        .icon(() -> new ItemStack(ModItems.BLOOD_DROP)).build();
  }
}
