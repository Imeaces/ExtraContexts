package me.lucko.extracontexts.calculators;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;

import org.bukkit.entity.Player;


public class GeyserConnectionCalculator implements ContextCalculator<Player> {
    private static final String KEY = "geyser:geyser-connection";

    @Override
    public void calculate(Player target, ContextConsumer consumer) {
        GeyserConnection connection = GeyserApi.api().connectionByUuid(target.getUniqueId());
        String booleanKey = Boolean.toString(connection != null);
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
