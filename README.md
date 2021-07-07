# FilRouge Petri Network

This is a project created for an IT course at IMT Atlantique engineer school.

More specifically, this is the FilRouge project, from the UE MAPD of the TAFF DCL.

The project has the structure of a Maven project, with root at `FilRouge`.

## Content

- Building
- Documentation
- Design choices
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

The methods of the class and the interfaces have been documented.

In the class diagram `doc/uml/2019-10-21-petrinet-class.pdf`
(exported from `FilRouge/diagram/petrinet-class.ucls`), the class and the 5 interfaces available to the user are to the left side.

## Design choices

Since we do not have a client to clarify the specification, we had to make
design choices. In particular:

- We decided to allow pulling a transition whose pullability critera are not
  fulfilled
- We decided to allow places to hold a negative number of counters

If these behaviors are undesired, we are ready to make changes according to the
new specification information the client brings.

## Tests

The following classes have unit tests:

- ArcPullMultiplicty
- ArcPushClass
- PlaceClass

The file "PetriNetClassTest" contains a large suite of functional tests of the
PetriNet.

## Glossary

The following terms are used in the project:

Place:
A node of the Petri network which can contain a number of tokens

Counter:
The number of tokens contained by a place

Transition:
A node of the Petri network which can be fired (pulled).

Pulling:
A synonyme of fireing. It can be used both for a transition or for an arc.

Arc:
In a Petri network, arcs can only link one place and one transition together.
Arcs are oriented, see "ArcPull" and "ArcPush"

ArcPull:
An arc, oriented from a place to a transition. Firing an ArcPull will remove
tokens from the place.

ArcPush:
An arc, oriented from a transtition to a place. Firing an ArcPush will add
tokens to their place.

Multiplicity (of an arc):
The "value" of the arc. The number of token it takes or adds to the place it's
linked to when it is fired. Note however that ArcPullVacuum and ArcPullZero
do not have multiplicities: They follow their own logic

## Self evaluation

### Comments

- [x] Code written in english
- [x] Comments all in the same language
- [x] Javadoc on all exposed methods
- [x] Comments dedicated to maintainers

### Style and conventions

- [x] Homogenous indentation (tabs)
- [x] UpperCamelCase for Classes and lowerCamelCase for variables
- [x] Methods are orderd
- [x] Names are meaningful (NB: subjective criterion)

### Modularity

- [?] No class in the root package (unsure)
- [x] ~~`package.info`~~ `package-info.java` describes each package
      responsability
- [x] Each class responsibility is defined
- [x] No public attributes
- [x] Methods are short (except for tests)

### Safety

- [x] Methods protect themselves
- [x] All methods **exposed to the user** has at least one test
- [x] Easy way to run all tests (`mvn test`)

### Evolutivity and Maintainability

- [x] Explicit imports
- [x] No magic constants (no constants at all, by good design)
- [x] Factorized code (as much as reasonable)

## Source management

The source are managed using git. A copy of the development repository is
available [on Github](https://github.com/mathieucaroff/FilRouge).
