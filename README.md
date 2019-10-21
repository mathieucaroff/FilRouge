# FilRouge Petri Network

This is a project created for an IT course at IMT Atlantique engineer school.

More specifically, this is the FilRouge project, from the UE MAPD of the TAFF DCL.

The project has the structure of a Maven project, with root at `FilRouge`.

## Content

- Building
- Documentation
- Tests
- Self evaluation
  - Comments
  - Modularity
  - Safety
  - Evolutivity and Maintainability
- Source management

## Building

Run the below command inside `FilRouge` to run the tests and generate a `.jar`
build in `target/`.

```
mvn package
```

## Documentation

One class is available to the user:

- PetriNetFactory

The interfaces visible to the user are the following:

- PetriNet
- Place
- Transition
- ArcPull
- ArcPush

In the diagrams `FilRouge/diagram/petrinet-class.ucls` and
`doc/uml/2019-10-21-petrinet-class.pdf`, the class and the 5 interfaces
available to the user are to the left side.

## Tests

The following classes have unit tests:

- ArcPullMultiplicty
- ArcPushClass
- PlaceClass

The file "PetriNetClassTest" contains a large suite of functional tests of the
PetriNet.

## Self evaluation

### Comments

- [x] Code written in english
- [x] Comments all in the same language
- [ ] Javadoc on public methods
- [ ] Comments dedicated to maintainers

### Style and conventions

- [x] Homogenous indentation (tabs)
- [x] UpperCamelCase for Classes and lowerCamelCase for variables
- [ ] Method are orderd
- [x] Names are meaningful (NB: subjective criterion)

### Modularity

- [?] No class in the root package (unsure)
- [x] ~~`package.info`~~ `package-info.java` describes each package responsability
- [ ] Each class responsibility is defined
- [x] No public attributes
- [x] Methods are short (except for tests)

### Safety

- [x] Methods protect themselves
- [x] Each **public** method has at least a test
- [x] Easy way to run all tests (`mvn test`)

### Evolutivity and Maintainability

- [x] Explicit imports
- [ ] No magic constants
- [x] Factorized code (as much as reasonable)

## Source management

The source are managed using git. A copy of the development repository is available [on Github](https://github.com/mathieucaroff/FilRouge).
