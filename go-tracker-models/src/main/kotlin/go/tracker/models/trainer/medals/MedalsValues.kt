package go.tracker.models.trainer.medals

import go.tracker.models.enums.Medals
import go.tracker.models.trainer.TrainerMedalStatus
import java.math.BigDecimal

data class MedalsValues(
    var jogger: BigDecimal? = null,
    var collector: BigDecimal? = null,
    var scientist: BigDecimal? = null,
    var breeder: BigDecimal? = null,
    var backpacker: BigDecimal? = null,
    var battleGirl: BigDecimal? = null,
    var gymLeader: BigDecimal? = null,
    var berryMaster: BigDecimal? = null,
    var champion: BigDecimal? = null,
    var legendaryPokemon: BigDecimal? = null,
    var pokemonRanger: BigDecimal? = null,
    var idol: BigDecimal? = null,
    var gentleman: BigDecimal? = null,
    var pilot: BigDecimal? = null,
    var fisher: BigDecimal? = null,
    var aceTrainer: BigDecimal? = null,
    var youngster: BigDecimal? = null,
    var pikachuFan: BigDecimal? = null,
    var greatLeagueVeteran: BigDecimal? = null,
    var ultraLeagueVeteran: BigDecimal? = null,
    var masterLeagueVeteran: BigDecimal? = null,
    var cameraman: BigDecimal? = null,
    var hero: BigDecimal? = null,
    var ultraHero: BigDecimal? = null,
    var purifier: BigDecimal? = null,
    var successor: BigDecimal? = null,
    var risingStar: BigDecimal? = null,
    var risingStarDuo: BigDecimal? = null,
    var triathlete: BigDecimal? = null,
    var tinyPokemonCollector: BigDecimal? = null,
    var jumboPokemonCollector: BigDecimal? = null,
    var picnicker: BigDecimal? = null,
    var friendFinder: BigDecimal? = null,
    var showcase: BigDecimal? = null,
    var routes: BigDecimal? = null,
    var wayfarer: BigDecimal? = null,
    var eliteCollector: BigDecimal? = null,
    var events: BigDecimal? = null,

    var regions: RegionsValues? = null,
    var finiteMedals: FiniteMedalsValues? = null,
    var typeMedals: TypeMedalsValues? = null,
) {
    fun map(listTrainerMedalStatus: List<TrainerMedalStatus>): MedalsValues = apply {
        listTrainerMedalStatus.forEach { medalStatus ->
            medalMapping[medalStatus.medal]?.invoke(medalStatus)
        }
    }

    private val medalMapping: Map<Medals, (TrainerMedalStatus) -> Unit> = mapOf(
        // Region Medals
        Medals.KANTO to { this.regions?.kanto = it.value },
        Medals.JOHTO to { this.regions?.johto = it.value },
        Medals.HOENN to { this.regions?.hoenn = it.value },
        Medals.SINNOH to { this.regions?.sinnoh = it.value },
        Medals.UNOVA to { this.regions?.unova = it.value },
        Medals.KALOS to { this.regions?.kalos = it.value },
        Medals.ALOLA to { this.regions?.alola = it.value },
        Medals.GALAR to { this.regions?.galar = it.value },
        Medals.HISUI to { this.regions?.hisui = it.value },
        Medals.PALDEA to { this.regions?.paldea = it.value },

        // Standard Medals
        Medals.JOGGER to { this.jogger = it.value },
        Medals.COLLECTOR to { this.collector = it.value },
        Medals.SCIENTIST to { this.scientist = it.value },
        Medals.BREEDER to { this.breeder = it.value },
        Medals.BACKPACKER to { this.backpacker = it.value },
        Medals.BATTLE_GIRL to { this.battleGirl = it.value },
        Medals.GYM_LEADER to { this.gymLeader = it.value },
        Medals.BERRY_MASTER to { this.berryMaster = it.value },
        Medals.CHAMPION to { this.champion = it.value },
        Medals.LEGENDARY_POKEMON to { this.legendaryPokemon = it.value },
        Medals.POKEMON_RANGER to { this.pokemonRanger = it.value },
        Medals.IDOL to { this.idol = it.value },
        Medals.GENTLEMAN to { this.gentleman = it.value },
        Medals.PILOT to { this.pilot = it.value },
        Medals.FISHER to { this.fisher = it.value },
        Medals.ACE_TRAINER to { this.aceTrainer = it.value },
        Medals.YOUNGSTER to { this.youngster = it.value },
        Medals.PIKACHU_FAN to { this.pikachuFan = it.value },
        Medals.GREAT_LEAGUE_VETERAN to { this.greatLeagueVeteran = it.value },
        Medals.ULTRA_LEAGUE_VETERAN to { this.ultraLeagueVeteran = it.value },
        Medals.MASTER_LEAGUE_VETERAN to { this.masterLeagueVeteran = it.value },
        Medals.CAMERAMAN to { this.cameraman = it.value },
        Medals.HERO to { this.hero = it.value },
        Medals.ULTRA_HERO to { this.ultraHero = it.value },
        Medals.PURIFIER to { this.purifier = it.value },
        Medals.SUCCESSOR to { this.successor = it.value },
        Medals.RISING_STAR to { this.risingStar = it.value },
        Medals.RISING_STAR_DUO to { this.risingStarDuo = it.value },
        Medals.TRIATHLETE to { this.triathlete = it.value },
        Medals.TINY_POKEMON_COLLECTOR to { this.tinyPokemonCollector = it.value },
        Medals.JUMBO_POKEMON_COLLECTOR to { this.jumboPokemonCollector = it.value },
        Medals.PICNICKER to { this.picnicker = it.value },
        Medals.FRIEND_FINDER to { this.friendFinder = it.value },
        Medals.SHOWCASE to { this.showcase = it.value },
        Medals.ROUTES to { this.routes = it.value },
        Medals.WAYFARER to { this.wayfarer = it.value },
        Medals.ELITE_COLLECTOR to { this.eliteCollector = it.value },
        Medals.EVENTS to { this.events = it.value },

        // Finite Medals
        Medals.UNOWN to { this.finiteMedals?.unown = it.value },
        Medals.MEGA_EVOLUTION_GURU to { this.finiteMedals?.megaEvolutionGuru = it.value },
        Medals.VIVILLON to { this.finiteMedals?.vivillon = it.value },

        // Type Medals
        Medals.SCHOOLKID to { this.typeMedals?.schoolkid = it.value },
        Medals.BLACK_BELT to { this.typeMedals?.blackBelt = it.value },
        Medals.BIRD_KEEPER to { this.typeMedals?.birdKeeper = it.value },
        Medals.PUNK_GIRL to { this.typeMedals?.punkGirl = it.value },
        Medals.RUIN_MANIAC to { this.typeMedals?.ruinManiac = it.value },
        Medals.HIKER to { this.typeMedals?.hiker = it.value },
        Medals.BUG_CATCHER to { this.typeMedals?.bugCatcher = it.value },
        Medals.HEX_MANIAC to { this.typeMedals?.hexManiac = it.value },
        Medals.DEPOT_AGENT to { this.typeMedals?.depotAgent = it.value },
        Medals.KINDLER to { this.typeMedals?.kindler = it.value },
        Medals.SWIMMER to { this.typeMedals?.swimmer = it.value },
        Medals.GARDENER to { this.typeMedals?.gardener = it.value },
        Medals.ROCKER to { this.typeMedals?.rocker = it.value },
        Medals.PSYCHIC to { this.typeMedals?.psychic = it.value },
        Medals.SKIER to { this.typeMedals?.skier = it.value },
        Medals.DRAGON_TAMER to { this.typeMedals?.dragonTamer = it.value },
        Medals.DELINQUENT to { this.typeMedals?.delinquent = it.value },
        Medals.FAIRY_TALE_GIRL to { this.typeMedals?.fairyTaleGirl = it.value }
    )

}