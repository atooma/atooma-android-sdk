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
**The Modules** are the foundamental of Atooma, they rappresent tipically a specific type of feature and contains Triggers, Condition Checkers and Performers.

To make a Modules you have to write the Constructor, implements registerComponents() where you can register Tirggers, Condition Checkers and Performers and implements defineUI()

Each components (*Modules, Triggers, Condition Checkers* and *Performers*) that implements *defineUI()* can call *setIcon()* and *setTitle()* giving as parameters the int id recource of a string or drawable from its project.

Triggers
--------
**Triggers** are components that are responsible to forword a notification when a
specific event occours. They are the "IF" part of a rule.
Each trigger can specify a list of input parameters and output variables; parameters and
variables must be declared in each trigger class.

There are 3 types of trigger:

- Trigger: the classic one, onInvoke method is called when the rule is activated
- IntentBasedTrigger: onReceive() method is called when a specified intent is called
- AlarmBasedTrigger: onTimeout() method is called at a specific moment set by the developer.

When a trigger wants to notify Atooma that the rule has to trigger, it must call the trigger() method.

Condition Checkers
------------------
**Condition Checkers** are components that check if a condition is true or false in the moment 
they are invoked and returns a boolean.

Condition Checkers must implement onInvoke() method and must be accompanied by an identical Trigger (same UI settings, same id ecc...)
Condition Checkers are used by Atoma when a user make a rule with two or more component in the IF sections.

Performers
----------
**Performers** are components that are invoked by Atooma when a rule is triggered.

Performers must implements onInvoke() method.

Create your first Module
------------------------
To create a simple Module, just extend Module class from the SDK.

Create the custroctur and call super() like this
```
	public TEST(Context context, String id, int version) {
		super(context, id, version);
	}
```

You need to implement two methods, registerComponents and defineUI.

The first method, *registerComponents*, allows you to register Triggers, ConditionCheckers and Performers. Call *registerTriggers()* or *registerConditionChecker()* or *registerPerformer()* to register a component like this

```
	public void registerComponents() {
		registerTrigger(new TR_Trigger(getContext(), "TRN", 1));
		registerConditionChecker(new CC_ConditionChecker(getContext(), "CC", 1));
		registerPerformer(new PE_Performer(getContext(), "PE", 1));
	}
```

The second method, defineUI, allows you to define a UI for your plugins, specifying icon
resources (normal and pressed icon) and a title resource.

```
	public void defineUI() {
		setIcon(R.drawable.ic_launcher, R.drawable.ic_launcher);
		setTitle(R.string.module_name);
	}
```

Create a simple Trigger
-----------------------
To create a simple Trigger, just extend Trigger class from the SDK.

Create the custroctur and call super().

You need to implement two methods, *defineUI()* and *onInvoke()*.
In defineUI() you can set icon and title as you did with the Module.

The method onInvoke here is called when the rule is activated; here you can insert your code and if you actually want to trigger your rule you can call *trigger()*.

If you want to use AlarmBasedTrigger you have to implement *getScheduleInfo()* like this
```
	public Schedule getScheduleInfo() {
		long now = System.currentTimeMillis();
		long triggerAtTime = now + 10000L;
		Schedule schedule = new Schedule.Builder().exact(true).triggerAtTime(triggerAtTime).build();
		return schedule;
	}
```
and then onTimeout will be called at the selected time.

If you want to use IntentBasedTrigger you have to implement *getIntentFilter()* like this

```
	public String getIntentFilter() {
		return Intent.ACTION_BATTERY_CHANGED;
	}
```

and then onReceive will be called when the intent will be fired

Create a simple ConditionChecker
--------------------------------
To create a simple ConditionChecker, just extend ConditionChecker class from the SDK.

Create the custroctur and call super().

You need to implement two methods, defineUI and onInvoke.
In *defineUI()* you can set icon and title as you did with the Module and Triggers.

The method onInvoke here is called when the trigger selected by the user befoure this Condition Checker will be triggered, if the condition is satisfied you can return true, otherwise return false.

Create a simple Performer
-------------------------
To create a simple Performer, just extend Performer class from the SDK.

Create the custroctur and call super().

You need to implement two methods, defineUI and onInvoke.
In *defineUI()* you can set icon and title as you did with the Module, Triggers and Condition Checker.

The method onInvoke here is called when the rule made by the user has triggered, and here you can do the code you want to execute.

Set parameters and variables
----------------------------
For each component, Triggers, ConditionCheckers and Performers you can set parameters and variables with the same code.

Parameters are the values that the user insert while he is creating the rule and they will be avaiable in onInvoke method (or onReceive or onTimeout). You can set the parameters like this

```
	public void declareParameters() {
		addParameter(R.string.parameter_name, R.string.parameter_ifnull, "NAME", "STRING", true, null);
	}
```

Where R.string.parameter\_name is the title of the parameter, R.string.parameter\_ifnull is the title of the parameter in the editor if the user won’t set a parameter, "NAME" is the id of the parameter, "STRING" the type, true indicate if the parameter is required or not to the user, and null is the string that indicate the path of an activity on your package that can be launched when the user edit the rule.

Then in onInvoke (for example) if you want to use the parameters you can get it in this way:

```
		String myParameters = (String) parameters.get("NAME");
```


Variables are the values that Triggers and Performers can pass in output. Triggers can pass some values to a Performers and Performers to other Performers. You can set the variables like this

```
	@Override
	public void declareVariables() {
		addVariable(R.string.parameter_name, "NAME", "STRING");
	}
```

Values allowed:

- "STRING"
- "BOOLEAN"
- "DURATION"
- "NUMBER"
- "NUMBER-FILTER"
- "PERCENT"
- "PERCENT-FILTER"
- "PLUGIN" (it’s like STRING, but you can use it with your own activity)
- "TEXT-FILTER"
- "TIME"
- "URI"
