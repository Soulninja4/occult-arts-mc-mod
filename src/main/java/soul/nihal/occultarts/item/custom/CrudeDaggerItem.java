package soul.nihal.occultarts.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import soul.nihal.occultarts.item.ModItems;

public class CrudeDaggerItem extends SwordItem {

  public CrudeDaggerItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
    super(material, attackDamage, attackSpeed, settings);
  }

  @Override
  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    if (attacker instanceof PlayerEntity) {
      PlayerEntity player = (PlayerEntity) attacker;
      if (!player.getMainHandStack().isEmpty() && player.getMainHandStack().getItem() == this) {
        if (target instanceof SheepEntity && !target.isAlive()) {
          player.getInventory().removeStack(player.getInventory().selectedSlot);
          player.getInventory().insertStack(player.getInventory().selectedSlot, new ItemStack(ModItems.RITUAL_DAGGER));
          player.sendMessage(Text.translatable("item.crude_dagger.awoken"), true);
        }
      }
    }
    return super.postHit(stack, target, attacker);
  }

}