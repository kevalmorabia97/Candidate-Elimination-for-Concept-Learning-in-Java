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
