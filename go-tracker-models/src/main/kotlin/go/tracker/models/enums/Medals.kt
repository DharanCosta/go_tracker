package go.tracker.models.enums

enum class Medals(
    val medalName: String,
    val finite: Boolean,
    val bronze: Long,
    val silver: Long,
    val gold: Long,
    val platinum: Long,
) {
    KANTO                   ("Kanto"    ,true , 20,	50,   100,	151),
    JOHTO                   ("Johto"    ,true , 5,	30,	70,	100),
    HOENN                   ("Hoenn"    ,true , 5,	40,	90,	135),
    SINNOH                  ("Sinnoh"   ,true , 5,	30,	80,	107),
    UNOVA                   ("Unova"    ,true , 5,	50,	100,	156),
    KALOS                   ("Kalos"    ,true , 5,	50,	100,	156),
    ALOLA                   ("Alola"    ,true , 5,	25,	50,	86),
    GALAR                   ("Galar"    ,true , 5,	25,	50,	89),
    HISUI                   ("Hisui"    ,true , 1,	3,	5,	    7 ),
    PALDEA                  ("Paldea"  ,true , 5,	30,	80,  103),

    JOGGER                  ("Jogger"   ,false, 10,	100,	1000,	10000),
    COLLECTOR               ("Collector",false, 30,	500,	2000,	50000),
    SCIENTIST               ("Scientist",false, 3,	20,	200,	2000),
    BREEDER                 ("Breeder"  ,false, 10,	100,	1000,	2500),
    BACKPACKER              ("Backpacker",false,100,	1000,	10000,	50000),
    BATTLE_GIRL             ("Battle Girl", false,10,	100,	1000,	4000),
    GYM_LEADER              ("Gym Leader",false, 10,	100,	1000,	15000),
    BERRY_MASTER            ("Berry Master", false, 10,	100,	1000,	15000),
    CHAMPION                ("Champion", false, 10,	100,	1000,	2000),
    LEGENDARY_POKEMON       ("Legendary Pokémon", false,10,	100,	1000,	2000),
    POKEMON_RANGER          ("Pokémon Ranger", false,10,	100,	1000,	2500),
    IDOL                    ("Idol",false, 1,	2,	3,	20),
    GENTLEMAN               ("Gentleman", false, 10,	100,	1000,	2500),
    PILOT                   ("Pilot", false, 1000,	100000,	1000000,	10000000),
    FISHER                  ("Fisher",false, 3,	50,	300,	1000),
    ACE_TRAINER             ("Ace Trainer", false, 10,	100,	1000,	2000),
    YOUNGSTER               ("Youngster", false, 3,	50,	300,	1000),
    PIKACHU_FAN             ("Pikachu Fan", false, 3,50,	300,	1000),
    GREAT_LEAGUE_VETERAN    ("Great League Veteran", false, 5,	50,	200,	1000),
    ULTRA_LEAGUE_VETERAN    ("Ultra League Veteran", false, 5,	50,	200,	1000),
    MASTER_LEAGUE_VETERAN   ("Master League Veteran", false, 5,	50,	200,	1000),
    CAMERAMAN               ("Cameraman", false, 10,	50,	200,	400),
    HERO                    ("Hero", false, 10, 	100,	1000,	2000),
    ULTRA_HERO              ("Ultra Hero", false, 1,	5,	20,	50),
    PURIFIER                ("Purifier", false, 1,	50,	500,	1000),
    SUCCESSOR                ("Successor", false, 1,	50,	500,	1000),
    RISING_STAR             ("Rising Star", false, 2,	10,	50,	150),
    RISING_STAR_DUO         ("Rising Star Duo", false,10,	100,	1000,	2000),
    TRIATHLETE              ("Triathlete", false, 1,	10,	50,100),
    TINY_POKEMON_COLLECTOR  ("Tiny Pokémon Collector", false,5,	25,	100,	500),
    JUMBO_POKEMON_COLLECTOR ("Jumbo Pokémon Collector", false, 5,	25,	100,	500),
    PICNICKER               ("Picnicker", false, 5, 	25, 	5500,	2500),
    FRIEND_FINDER           ("Friend Finder", false, 1,10,20,50),
    SHOWCASE                ("Showcase Star", false, 1,10,50,100),
    ROUTES                  ("Expert Navigator", false, 10, 50,200,600),
    WAYFARER                ("Wayfarer", false, 50, 500,1000,1500),
    ELITE_COLLECTOR         ("Elite Collector", false, 0,0,0,0),
    EVENTS                  ("Events", false, 0,0,0,0),

    UNOWN                   ("Unown", true, 3,	10,	26,	28),
    MEGA_EVOLUTION_GURU     ("Mega Evolution Guru", true, 1,24,	36,	46),
    VIVILLON                ("Vivillon Collector", true, 0,0,0,18),

    SCHOOLKID               ("SchoolKid", false, 10,	50,	200, 0),
    BLACK_BELT              ("Black Belt", false, 10,	50,	200,0),
    BIRD_KEEPER             ("Bird Keeper",false, 10,50,	200,0),
    PUNK_GIRL               ("Punk Girl", false, 10,	50,	200, 0),
    RUIN_MANIAC             ("Ruin Maniac", false,  10,	50,	200, 0),
    HIKER                   ("Hiker", false,  10,	50,	200, 0),
    BUG_CATCHER             ("Bug Catcher", false,  10,	50,	200, 0),
    HEX_MANIAC              ("Hex Maniac", false,  10,	50,	200, 0),
    DEPOT_AGENT             ("Depot Agent", false,  10,	50,	200, 0),
    KINDLER                 ("Kindler", false,  10,	50,	200, 0),
    SWIMMER                 ("Swimmer", false,  10,	50,	200, 0),
    GARDENER                ("Gardener", false,  10,	50,	200, 0),
    ROCKER                  ("Rocker", false,  10,	50,	200, 0),
    PSYCHIC                 ("Psychic", false,  10,	50,	200, 0),
    SKIER                   ("Skier", false,  10,	50,	200, 0),
    DRAGON_TAMER           ("Dragon Tamer", false,  10,	50,	200, 0),
    DELINQUENT              ("Delinquent", false,  10,	50,	200, 0),
    FAIRY_TALE_GIRL         ("Fairy Tale Girl", false,  10,	50,	200, 0);

    fun getMedalLimit(medal: Medals): Long {
        val limit: Long
        if(isFinite(medal) && medal.platinum > 0) limit = medal.platinum  else limit = medal.gold
        return limit
    }

    fun isFinite(medal: Medals) = medal.finite

}