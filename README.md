# ExtraContexts
Provides a number of extra "contexts" for [LuckPerms](https://github.com/lucko/LuckPerms).


## About
Contexts are a concept in LuckPerms that allows permissions to be set to apply only in certain circumstances. See [here](https://github.com/lucko/LuckPerms/wiki/Context) for more info.

This plugin (ExtraContexts) provides a number of contexts for Bukkit servers. The supported contexts are listed below.


## Downloads and Usage

* The plugin can be downloaded from [Jenkins](https://ci.lucko.me/job/ExtraContexts/). [[direct link](https://ci.lucko.me/job/ExtraContexts/lastSuccessfulBuild/artifact/target/ExtraContexts.jar)]
* To use it, just add it to your plugins folder and enable the contexts you want to use. You have to enable each placeholder in `config.yml`

##### How do I check if it's working?
A player's "current contexts" are listed when you run `/lp user <user> info`.


## Contexts
___
#### `authme:login`
Returns the login status in Authme

e.g.

> authme:login=unrestricted
> authme:login=npc
> authme:login=logon
> authme:login=registered
> authme:login=online
> authme:login=offline-registered
> authme:login=offline
> authme:login=unknown

___
#### `geyser:geyser-connection`
Returns true or false if the player is connected from geyser

e.g.

> geyser:geyser-connection=true

___
#### `floodgate:floodgate-player`
Returns true or false if the player is login through floodgate

e.g.

> floodgate:floodgate-player=true

___
#### `worldguard:region`
Returns the name of each WorldGuard region the player is currently in

e.g.

> worldguard:region=spawn

___
#### `worldguard:in-region`
Returns true or false if the player is in a WorldGuard region

e.g.

> worldguard:in-region=true

___
#### `worldguard:flag-xxx`
Returns the value of each flag set by WorldGuard in the region the player is currently in

e.g.

> worldguard:flag-build=allow

___
#### `whitelisted`
Returns if the player is whitelisted on the server or not

e.g.

> whitelisted=true

___
#### `team`
Returns the name of the team the players is in

e.g.

> team=pvp-blue

___
#### `has-played-before`
Returns if the player has connected to the server before, or if this is their first time

e.g.

> has-played-before=false

___
#### PlaceholderAPI
Returns the result for a defined set of placeholders.

e.g.

**config:**
```yml
placeholderapi-placeholders:
  allowflight: "%player_allow_flight%"
```

> allowflight=true

___