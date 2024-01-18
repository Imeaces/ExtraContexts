package me.lucko.extracontexts.calculators;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;
import fr.xephi.authme.api.v3.AuthMeApi;

import org.bukkit.entity.Player;


public class AuthmeLoginCalculator implements ContextCalculator<Player> {
    private static final String KEY = "authme:login";

    @Override
    public void calculate(Player target, ContextConsumer consumer) {
        AuthmeLoginStatus status = getLoginStatus(target);
        consumer.accept(KEY, status.getStatusText());
    }

    private AuthmeLoginStatus getLoginStatus(Player player){
        AuthMeApi authmeApi = AuthMeApi.getInstance();

        AuthmeLoginStatus status;
        if (player == null){ //会有这种情况吗？
            status = AuthmeLoginStatus.UNKNOWN;
        } else if (authmeApi.isUnrestricted(player)){
            status = AuthmeLoginStatus.UNRESTRICTED;
        } else if (authmeApi.isNpc(player)){
            status = AuthmeLoginStatus.NPC;
        } else if (authmeApi.isAuthenticated(player)){
            status = AuthmeLoginStatus.LOGON;
        } else if (player.isOnline()){
            if (authmeApi.isRegistered(player.getName())){
                status = AuthmeLoginStatus.REGISTERED;
            } else {
                status = AuthmeLoginStatus.ONLINE;
            }
        } else if (!player.isOnline()){
            if (authmeApi.isRegistered(player.getName())){
                status = AuthmeLoginStatus.OFFLINE_REGISTERED;
            } else {
                status = AuthmeLoginStatus.OFFLINE;
            }
        } else {
            status = AuthmeLoginStatus.UNKNOWN;
        }

        return status;
    }

    private enum AuthmeLoginStatus {
        UNRESTRICTED("unrestricted"),
        NPC("npc"),
        LOGON("logon"),
        REGISTERED("registered"),
        ONLINE("online"),
        OFFLINE_REGISTERED("offline-registered"),
        OFFLINE("offline"),
        UNKNOWN("unknown");

        private String statusText;
        public String getStatusText(){
            return statusText;
        }

        private AuthmeLoginStatus(String statusText){
            this.statusText = statusText;
        }
    }

    @Override
    public ContextSet estimatePotentialContexts() {
        ImmutableContextSet.Builder builder = ImmutableContextSet.builder();
        for (Object status : AuthmeLoginStatus.values()){
            AuthmeLoginStatus status0 = (AuthmeLoginStatus) status;
            builder.add(KEY, status0.getStatusText());
        }
        return builder.build();
    }

}
