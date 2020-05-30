package me.lucko.extracontexts.calculators;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;

import org.bukkit.entity.Player;

public class WhitelistedCalculator implements ContextCalculator<Player> {
    private static final String KEY = "whitelisted";

    @Override
    public void calculate(Player target, ContextConsumer consumer) {
        consumer.accept(KEY, String.valueOf(target.isWhitelisted()));
    }

    @Override
    public ContextSet estimatePotentialContexts() {
        return ImmutableContextSet.builder()
                .add(KEY, "true")
                .add(KEY, "false")
                .build();
    }

}
