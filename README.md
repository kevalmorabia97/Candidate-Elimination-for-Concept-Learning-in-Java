# Candidate-Elimination-for-Concept-Learning-in-Java
```
Class# Set of animals:
====== ===============================================================
 1 (41) aardvark, antelope, bear, boar, buffalo, calf,
        cavy, cheetah, deer, dolphin, elephant,
        fruitbat, giraffe, girl, goat, gorilla, hamster,
        hare, leopard, lion, lynx, mink, mole, mongoose,
        opossum, oryx, platypus, polecat, pony,
        porpoise, puma, pussycat, raccoon, reindeer,
        seal, sealion, squirrel, vampire, vole, wallaby,wolf
 2 (20) chicken, crow, dove, duck, flamingo, gull, hawk,
        kiwi, lark, ostrich, parakeet, penguin, pheasant,
        rhea, skimmer, skua, sparrow, swan, vulture, wren
 3 (5)  pitviper, seasnake, slowworm, tortoise, tuatara 
 4 (13) bass, carp, catfish, chub, dogfish, haddock,
        herring, pike, piranha, seahorse, sole, stingray, tuna
 5 (4)  frog, frog, newt, toad 
 6 (8)  flea, gnat, honeybee, housefly, ladybird, moth, termite, wasp
 7 (10) clam, crab, crayfish, lobster, octopus,
        scorpion, seawasp, slug, starfish, worm

Number of Instances: 101
Number of Attributes: 17 (15 Boolean attributes, 2 numerics)
Attribute Information: (name of attribute and type of value domain)
   1. hair		Boolean
   2. feathers		Boolean
   3. eggs		Boolean
   4. milk		Boolean
   5. airborne		Boolean
   6. aquatic		Boolean
   7. predator		Boolean
   8. toothed		Boolean
  9. backbone		Boolean
  10. breathes		Boolean
  11. venomous		Boolean
  12. fins		Boolean
  13. legs		Numeric (set of values: {0,2,4,5,6,8})
  14. tail		Boolean
  15. domestic		Boolean
  16. catsize		Boolean
  17. type		Numeric (integer values in range [1,7])
Missing Attribute Values: None
```
<hr>

```
Procedure:
1.According to the training data there were 7 classes into which animals were classified.
2.We used one vs all method as mentioned in the question. So, in the training data first we considered all the instances with classification as class 1 as positive and rest as negative.
3.Now to generate the specific boundary we first considered only the positive examples and neglected the negative examples. Hence the specific boundary was generated using the Candidate Elimination Algorithm. Then we generated the general boundary considering the negative examples using the algorithm.
4.The same logic was repeated for all the classes.
```
<hr>

```
Training Data:
1,0,0,1,0,0,1,1,1,1,0,0,4,0,0,1,1
1,0,0,1,0,0,0,1,1,1,0,0,4,1,0,1,1
0,0,1,0,0,1,1,1,1,0,0,1,0,1,0,0,4
1,0,0,1,0,0,1,1,1,1,0,0,4,0,0,1,1
1,0,0,1,0,0,1,1,1,1,0,0,4,1,0,1,1
1,0,0,1,0,0,0,1,1,1,0,0,4,1,0,1,1
1,0,0,1,0,0,0,1,1,1,0,0,4,1,1,1,1
0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,4
0,0,1,0,0,1,1,1,1,0,0,1,0,1,0,0,4
1,0,0,1,0,0,0,1,1,1,0,0,4,0,1,0,1
...
...
```
<hr>

```
Output:
*****For Class = 1*****
Specific Boundary for Class 1
[all, 0, all, 1, all, all, all, all, 1, 1, 0, all, all, all, all, all]
Generic Boundary for Class 1
[all, all, all, 1, all, all, all, all, all, all, all, all, all, all, all, all]

*****For Class = 2*****
Specific Boundary for Class 2
[0, 1, 1, 0, all, all, all, 0, 1, 1, 0, 0, 2, 1, all, all]
Generic Boundary for Class 2
[all, 1, all, all, all, all, all, all, all, all, all, all, all, all, all, all]
[0, all, all, all, all, all, all, all, all, all, all, all, 2, all, all, all]
[all, all, 1, all, all, all, all, all, all, all, all, all, 2, all, all, all]
[all, all, all, all, all, all, all, 0, all, all, all, all, 2, all, all, all]
[all, all, all, 0, all, all, all, all, all, all, all, all, 2, all, all, all]

*****For Class = 3*****
Current Specific Boundary: [0, 0, all, 0, 0, all, all, all, 1, all, all, 0, all, 1, 0, all]
INCONSISTENT DATA: [0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 4, 1, 0, 0, 5]
Concept cannot be learned

*****For Class = 4*****
Specific Boundary for Class 4
[0, 0, 1, 0, 0, 1, all, 1, 1, 0, all, 1, 0, 1, all, all]
Generic Boundary for Class 4
[all, all, 1, all, all, all, all, all, all, all, all, 1, all, all, all, all]
[all, all, all, 0, all, all, all, all, all, all, all, 1, all, all, all, all]
[all, all, all, all, all, all, all, all, all, 0, all, 1, all, all, all, all]
[all, all, 1, all, all, all, all, 1, all, 0, all, all, all, all, all, all]
[all, all, 1, all, all, all, all, all, 1, 0, all, all, all, all, all, all]
[all, all, 1, all, all, all, all, all, all, 0, all, all, all, 1, all, all]
[all, all, 1, all, all, 1, all, 1, all, all, all, all, 0, all, all, all]
[all, all, 1, all, all, 1, all, all, 1, all, all, all, 0, all, all, all]
[all, all, 1, all, all, 1, all, all, all, all, all, all, 0, 1, all, all]

*****For Class = 5*****
Specific Boundary for Class 5
[0, 0, 1, 0, 0, 1, all, 1, 1, 1, all, 0, 4, all, 0, 0]
Generic Boundary for Class 5
[all, all, 1, all, all, 1, all, 1, all, all, all, 0, all, all, all, all]
[all, all, all, all, 0, 1, all, all, all, 1, all, all, all, all, all, 0]
[all, 0, all, 0, all, 1, all, all, all, 1, all, all, all, all, all, all]
[all, 0, all, all, all, 1, all, all, all, 1, all, all, all, all, all, 0]
[all, all, 1, all, all, 1, all, 1, all, 1, all, all, all, all, all, all]
[all, all, all, 0, all, 1, all, 1, all, 1, all, all, all, all, all, all]
[all, all, all, all, all, 1, all, 1, all, 1, all, all, all, all, all, 0]
[0, 0, 1, all, all, 1, all, all, all, 1, all, all, all, all, all, all]
[0, 0, all, all, all, 1, all, all, all, 1, all, 0, all, all, all, all]
[0, all, all, all, all, 1, all, 1, all, 1, all, 0, all, all, all, all]
[all, all, 1, all, all, 1, all, 1, all, all, all, all, 4, all, all, all]
[all, all, 1, all, 0, 1, all, all, 1, all, all, 0, all, all, all, 0]
[0, all, all, all, all, 1, all, 1, all, all, all, all, 4, all, all, all]
[0, all, all, all, all, 1, all, all, 1, all, all, all, 4, all, all, all]
[0, all, all, all, all, 1, all, all, all, 1, all, all, 4, all, all, all]
[all, all, all, 0, all, 1, all, 1, all, all, all, all, 4, all, all, all]
[all, all, all, 0, all, 1, all, all, 1, all, all, all, 4, all, all, all]
[all, all, all, 0, all, 1, all, all, all, 1, all, all, 4, all, all, all]
[all, all, all, all, all, 1, all, 1, all, all, all, all, 4, all, all, 0]
[all, all, all, all, all, 1, all, all, 1, all, all, all, 4, all, all, 0]
[all, all, all, all, all, 1, all, all, all, 1, all, all, 4, all, all, 0]
[0, 0, 1, all, all, 1, all, all, 1, all, all, 0, all, all, all, all]
[all, 0, 1, 0, all, 1, all, all, 1, all, all, 0, all, all, all, all]
[all, 0, 1, all, all, 1, all, all, 1, all, all, 0, all, all, all, 0]

*****For Class = 6*****
Specific Boundary for Class 6
[all, 0, 1, 0, all, 0, all, 0, 0, 1, all, 0, 6, 0, all, 0]
Generic Boundary for Class 6
[all, all, all, all, all, 0, all, all, all, all, all, all, 6, all, all, all]
[all, all, all, all, all, all, all, all, all, 1, all, all, 6, all, all, all]

*****For Class = 7*****
Current Specific Boundary: [0, 0, all, 0, 0, all, all, 0, 0, all, all, 0, all, all, 0, all]
INCONSISTENT DATA: [0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 6, 0, 0, 0, 6]
Concept cannot be learned
```

