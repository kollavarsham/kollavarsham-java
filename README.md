kollavarsham-java
=================

## Information
The JAVA API port for Kollavarsham (http://kollavarsham.org)

## Getting Started
To use this source, clone this repository to local and create an Eclipse Java project from the cloned directory.
jars for download and ant build scripts will be added soon.

## Usage

#### As library/module

```
Kollavarsham kollavarsham = new Kollavarsham(Calendar ModernDate);
kollavarsham.setOptions(Boolean bija, Double latitude, Double longitude);
kollavarsham.FromGregorian();
kollavarsham.get(int field);
where field is:
Kollavarsham.MALAYALAM_YEAR;
Kollavarsham.MALAYALAM_MONTH_NUM;
Kollavarsham.MALAYALAM_DAY_OF_MONTH;
Kollavarsham.MALAYALAM_NAKSHATRAM;
```

## Documentation
TODO

## Contributing
In lieu of a formal styleguide, take care to maintain the existing coding style. Add unit tests for any new or changed functionality.

## Release History
_(Nothing yet)_

## License
Copyright (c) 2014 The Kollavarsham Team. Licensed under the MIT license.