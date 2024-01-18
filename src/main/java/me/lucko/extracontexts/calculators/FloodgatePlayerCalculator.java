package me.lucko.extracontexts.calculators;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import org.bukkit.entity.Player;


public class FloodgatePlayerCalculator implements ContextCalculator<Player> {
    private static final String KEY = "floodgate:floodgate-player";

    @Override
    public void calculate(Player target, ContextConsumer consumer) {
        FloodgatePlayer floodgatePlayer = FloodgateApi.getInstance().getPlayer(target.getUniqueId());
        String booleanKey = Boolean.toString(floodgatePlayer != null);
        consumer.accept(KEY, booleanKey);
    }

    @Override
    public ContextSet estimatePotentialContexts() {
        ImmutableContextSet.Builder builder = ImmutableContextSet.builder();
        builder.add(KEY, Boolean.toString(Boolean.TRUE));
        builder.add(KEY, Boolean.toString(Boolean.FALSE));
        return builder.build();
    }

}
