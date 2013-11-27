Atooma SDK
==========

Atooma Software Development Kit allows you to write your own modules for Atooma app.

Getting started
---------------
- Download the zip file at …, unzip it and open the “tools” folder.
- Launch our script to create a skeleton for your first plugin:

```
./create_atooma_plugin PluginName /path/to/plugin/directory
```
- Now you can start working on your plugin! Using Eclipse you can go to 

```
File -> New -> Android Project from existing Code 
```
and browse the folder you created.

How Atooma Works
----------------
(Explain here how Atooma works, introducing TRs, CCs and PEs)

Triggers
--------
Triggers are components that are responsible to forword a notification when a
specific event occours. They are the "IF" part of a rule.
Each trigger can specify a list of input parameters and output variables; parameters and
variables must be declared in each trigger class.

There are 3 types of trigger:

- Trigger: the classic one, onInvoke method is called when the rule is activated
- IntentBasedTrigger: onReceive() method is called when a specified intent is called
- AlarmBasedTrigger: onTimeout() method is called at a specific moment set by the developer.

When a trigger wants to notify Atooma that the rule has to trigger, it must call the trigger() method.

Create your first Module
------------------------
To create a simple Module, just extend Module class from the SDK.
...
You need to implement two methods, registerComponents and defineUI.
…
The first method, registerComponents, allows you to register Triggers, ConditionCheckers and
Performers.
….
The second method, defineUI, allows you to define a UI for your plugins, specifying icon
resources (normal and pressed icon) and a title resource.
Create a simple Trigger
To create a simple Trigger, just extend Trigger class from the SDK.
...
You need to implement two methods, onInvoke and defineUI.
…
