# TellrawAPI
==========

Chances are, if you are a server owner, you are simply here because one of your plugins rely on this plugin in order to function correctly. If you are a server owner, just put this in your plugins.
If you are a developer, keep on reading to learn how to use this properly!

## Usage

Create multiple objects that each contain StringBuilders. After you create all of them, you must finalize it (You can finalize multiple of them together). Then a method that lets you send the StringBuilder (or a string if that's your style) can let you either send it to either one, multiple, or all players!

----
### TellrawText

Constructor Syntax | Description
-------------------|------------
(String text) | Normal, white, text
(String text, ChatColor cc) | Add some color to your text!

----
### TellrawURL

Constructor Syntax | Description
-------------------|------------
(String text, URL url) | Prompt to open a URL when the text displays. Text is AQUA.
(String text, String url) | Same as above.
(String text, URL url, ChatColor cc) | Prompt to open a URL, custom ChatColor.
(String text, String url, ChatColor cc) | Same as above
----

### TellrawCommand

Constructor Syntax | Description
------------------ | -----------
(String text, String chat) | Has the player send the chat message when they click the text. (Begin with '/' to have them run a command, they must have permission for it). Text is WHITE
(String text, String chat, ChatColor cc) | Same as above, custom color
(String text, Command cmd) | Have the player run the command on click, without args. Text is WHITE
(String text, Command cmd, String args) | Run the command on click, with args. Text is WHITE
String text, Command cmd, ChatColor cc) | Run the command on click, no args, custom ChatColor
(String text, Command cmd, String args, ChatColor cc) | Run the command on click, with args, custom ChatColor

----
### TellrawSuggest

Constructor Syntax | Description
-------------------|------------
(String text, String chat) | Puts the chat String in their message box when text is clicked, text is WHITE
(String text, String chat, ChatColor cc) | Same as above, but with custom ChatColor
----
### TellrawParent<</size>>

Each of the above classes extend this class


#### Formats
Method | Description
-------|------------
setBold() | Sets the object to be bold
setItalic() | Sets the object to be italic
setUnderlined() | Sets the object to be underlined
setStrikethrough() | Sets the object to be strikethrough
setObfuscated() | Sets the object to be obfuscated (aka "magic") text
setMagic() -|calls setObfuscated()


#### HoverEvents
Method | Description
-------|------------
setHover(String s) | Displays 1 line of a string of your choosing
setHover(ItemStack i) | Displays an item's data when you hover (Working on getting enchants to work
setHover(String...lines) | Displays as many lines as you want when you hover. (Creates an item with custom name/lore
setHover(Achievement a) | Displays an achievement when you hover
setHover(Entity e) | Displays an entity's data when you hover (Will be available in 1.8, not available in 1.7)

And this last thing | Description
-------------------- | ---------
StringBuilder getStringBuilder() | Puts the finishing touches on the StringBuilder and returns the raw message. You still must finalize it before sending it

----
### TellrawAPI (Main class)

Method (all are static)| Description
-------|------------
StringBuilder finalize(StringBuilder...sb) | Puts the proper prefix and suffix for each arg, and returns the final result
StringBuilder finalize(TellrawParent tr) | Same as above, but you can instead just put the objects into it
void sendToAll(StringBuilder msg) | Sends the JSON in the msg to every player
void sendToAll(String msg) | If you either have your own string to send, or just like strings, you can use this
void sendTo(StringBuilder msg, Player...players) | Sends to specified players
void sendTo(String msg, Player...players) | Same but with strings
