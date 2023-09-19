import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
        appBar: AppBar(
          title: const Text('Study to Container'),
        ),
        body: Body()),
  ));
}

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const Column(children: [
      TestCheckBox(),
      TestRadioButton(),
      TestSlider(),
      TestSwitch(),
      TestPopUpMenu(),
    ]);
  }
}

class TestPopUpMenu extends StatefulWidget {
  const TestPopUpMenu({super.key});

  @override
  State<TestPopUpMenu> createState() => _TestPopUpMenuState();
}

enum TestPopUpMenuValue { test1, test2, test3 }

class _TestPopUpMenuState extends State<TestPopUpMenu> {
  TestPopUpMenuValue? selectValue = TestPopUpMenuValue.test1;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        PopupMenuButton(
          itemBuilder: (context) {
            return [
              PopupMenuItem(
                value: TestPopUpMenuValue.test1,
                child: Text(TestPopUpMenuValue.test1.name),
              ),
              PopupMenuItem(
                value: TestPopUpMenuValue.test2,
                child: Text(TestPopUpMenuValue.test2.name),
              ),
              PopupMenuItem(
                value: TestPopUpMenuValue.test3,
                child: Text(TestPopUpMenuValue.test3.name),
              ),
            ];
          },
          onSelected: (newValue) => setState(() => selectValue = newValue),
        ),
        Text('Selected Value : ${selectValue!.name}'),
      ],
    );
  }
}

class TestSwitch extends StatefulWidget {
  const TestSwitch({super.key});

  @override
  State<TestSwitch> createState() => _TestSwitchState();
}

class _TestSwitchState extends State<TestSwitch> {
  bool value = false;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Switch(
            value: value,
            onChanged: (newValue) => setState(() => value = newValue)),
        CupertinoSwitch(
            value: value,
            onChanged: (newValue) => setState(() => value = newValue)),
        Text('$value'),
      ],
    );
  }
}

class TestSlider extends StatefulWidget {
  const TestSlider({super.key});

  @override
  State<TestSlider> createState() => _TestSliderState();
}

class _TestSliderState extends State<TestSlider> {
  double value = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text('${value.round()}'),
        Slider(
            activeColor: Colors.amberAccent,
            label: '$value',
            divisions: 100,
            min: 0,
            max: 100,
            value: value.round().toDouble(),
            onChanged: (newValue) => setState(() => value = newValue)),
      ],
    );
  }
}

class TestRadioButton extends StatefulWidget {
  const TestRadioButton({super.key});

  @override
  State<TestRadioButton> createState() => _TestRadioButtonState();
}

enum TestRadioValue { test1, test2, test3 }

class _TestRadioButtonState extends State<TestRadioButton> {
  TestRadioValue? selectValue;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ListTile(
          leading: Radio<TestRadioValue>(
              value: TestRadioValue.test1,
              groupValue: selectValue,
              onChanged: (value) => setState(() => selectValue = value!)),
          title: Text("label : ${TestRadioValue.test1.name}"),
          onTap: () {
            setState(() {
              if (selectValue != TestRadioValue.test1) {
                selectValue = TestRadioValue.test1;
              }
            });
          },
        ),
        ListTile(
          leading: Radio<TestRadioValue>(
              value: TestRadioValue.test2,
              groupValue: selectValue,
              onChanged: (value) => setState(() => selectValue = value!)),
          title: Text("label : ${TestRadioValue.test2.name}"),
          onTap: () {
            setState(() {
              if (selectValue != TestRadioValue.test2) {
                selectValue = TestRadioValue.test2;
              }
            });
          },
        ),
        ListTile(
          leading: Radio<TestRadioValue>(
              value: TestRadioValue.test3,
              groupValue: selectValue,
              onChanged: (value) => setState(() => selectValue = value!)),
          title: Text("label : ${TestRadioValue.test3.name}"),
          onTap: () {
            setState(() {
              if (selectValue != TestRadioValue.test3) {
                selectValue = TestRadioValue.test3;
              }
            });
          },
        ),
      ],
    );
  }
}

class TestCheckBox extends StatefulWidget {
  const TestCheckBox({super.key});

  @override
  State<TestCheckBox> createState() => _TestCheckBoxState();
}

class _TestCheckBoxState extends State<TestCheckBox> {
  late List<bool> values;

  @override
  void initState() {
    super.initState();
    values = [false, false, false];
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Checkbox(
            value: values[0],
            onChanged: (value) => onChangeValue(0, value ?? false)),
        Checkbox(
            value: values[1],
            onChanged: (value) => onChangeValue(1, value ?? false)),
        Checkbox(
            value: values[2],
            onChanged: (value) => onChangeValue(2, value ?? false)),
      ],
    );
  }

  void onChangeValue(int index, bool value) {
    setState(() {
      values[index] = value;
    });
  }
}
