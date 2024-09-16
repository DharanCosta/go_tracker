package go.tracker.api.response.medals

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import go.tracker.models.trainer.medals.FiniteMedalsValues
import go.tracker.models.trainer.medals.MedalsValues
import go.tracker.models.trainer.medals.RegionsValues
import go.tracker.models.trainer.medals.TypeMedalsValues
import java.math.BigDecimal

@JsonInclude(Include.NON_NULL)
data class MedalStatusResponse(
    val jogger: BigDecimal? = null,
    val collector: BigDecimal? = null,
    val scientist: BigDecimal? = null,
    val breeder: BigDecimal? = null,
    val backpacker: BigDecimal? = null,
    val battleGirl: BigDecimal? = null,
    val gymLeader: BigDecimal? = null,
    val berryMaster: BigDecimal? = null,
    val champion: BigDecimal? = null,
    val legendaryPokemon: BigDecimal? = null,
    val pokemonRanger: BigDecimal? = null,
    val idol: BigDecimal? = null,
    val gentleman: BigDecimal? = null,
    val pilot: BigDecimal? = null,
    val fisher: BigDecimal? = null,
    val aceTrainer: BigDecimal? = null,
    val youngster: BigDecimal? = null,
    val pikachuFan: BigDecimal? = null,
    val greatLeagueVeteran: BigDecimal? = null,
    val ultraLeagueVeteran: BigDecimal? = null,
    val masterLeagueVeteran: BigDecimal? = null,
    val cameraman: BigDecimal? = null,
    val hero: BigDecimal? = null,
    val ultraHero: BigDecimal? = null,
    val purifier: BigDecimal? = null,
    val successor: BigDecimal? = null,
    val risingStar: BigDecimal? = null,
    val risingStarDuo: BigDecimal? = null,
    val triathlete: BigDecimal? = null,
    val tinyPokemonCollector: BigDecimal? = null,
    val jumboPokemonCollector: BigDecimal? = null,
    val picnicker: BigDecimal? = null,
    val friendFinder: BigDecimal? = null,
    val showcase: BigDecimal? = null,
    val routes: BigDecimal? = null,
    val wayfarer: BigDecimal? = null,
    val eliteCollector: BigDecimal? = null,
    val events: BigDecimal? = null,

    val regions: RegionsValuesResponse? = null,
    val finiteMedals: FiniteMedalsValuesResponse? = null,
    val typeMedals: TypeMedalsValuesResponse? = null,
) {
    fun mapToMedalStatusResponse(medalValues: MedalsValues): MedalStatusResponse {
        return MedalStatusResponse(
            jogger = medalValues.jogger,
            collector = medalValues.collector,
            scientist = medalValues.scientist,
            breeder = medalValues.breeder,
            backpacker = medalValues.backpacker,
            battleGirl = medalValues.battleGirl,
            gymLeader = medalValues.gymLeader,
            berryMaster = medalValues.berryMaster,
            champion = medalValues.champion,
            legendaryPokemon = medalValues.legendaryPokemon,
            pokemonRanger = medalValues.pokemonRanger,
            idol = medalValues.idol,
            gentleman = medalValues.gentleman,
            pilot = medalValues.pilot,
            fisher = medalValues.fisher,
            aceTrainer = medalValues.aceTrainer,
            youngster = medalValues.youngster,
            pikachuFan = medalValues.pikachuFan,
            greatLeagueVeteran = medalValues.greatLeagueVeteran,
            ultraLeagueVeteran = medalValues.ultraLeagueVeteran,
            masterLeagueVeteran = medalValues.masterLeagueVeteran,
            cameraman = medalValues.cameraman,
            hero = medalValues.hero,
            ultraHero = medalValues.ultraHero,
            purifier = medalValues.purifier,
            successor = medalValues.successor,
            risingStar = medalValues.risingStar,
            risingStarDuo = medalValues.risingStarDuo,
            triathlete = medalValues.triathlete,
            tinyPokemonCollector = medalValues.tinyPokemonCollector,
            jumboPokemonCollector = medalValues.jumboPokemonCollector,
            picnicker = medalValues.picnicker,
            friendFinder = medalValues.friendFinder,
            showcase = medalValues.showcase,
            routes = medalValues.routes,
            wayfarer = medalValues.wayfarer,
            eliteCollector = medalValues.eliteCollector,
            events = medalValues.events,

            regions = medalValues.regions?.let { mapToRegionsValuesResponse(it) },
            finiteMedals = medalValues.finiteMedals?.let { mapToFiniteMedalsValuesResponse(it) },
            typeMedals = medalValues.typeMedals?.let { mapToTypeMedalsValuesResponse(it) }
        )
    }

    private fun mapToRegionsValuesResponse(regions: RegionsValues): RegionsValuesResponse {
        return RegionsValuesResponse(
            kanto = regions.kanto,
            johto = regions.johto,
            hoenn = regions.hoenn,
            sinnoh = regions.sinnoh,
            unova = regions.unova,
            kalos = regions.kalos,
            alola = regions.alola,
            galar = regions.galar,
            hisui = regions.hisui,
            paldea = regions.paldea
        )
    }

    private fun mapToFiniteMedalsValuesResponse(finiteMedals: FiniteMedalsValues): FiniteMedalsValuesResponse {
        return FiniteMedalsValuesResponse(
            unown = finiteMedals.unown,
            megaEvolutionGuru = finiteMedals.megaEvolutionGuru,
            vivillon = finiteMedals.vivillon
        )
    }

    private fun mapToTypeMedalsValuesResponse(typeMedals: TypeMedalsValues): TypeMedalsValuesResponse {
        return TypeMedalsValuesResponse(
            schoolkid = typeMedals.schoolkid,
            blackBelt = typeMedals.blackBelt,
            birdKeeper = typeMedals.birdKeeper,
            punkGirl = typeMedals.punkGirl,
            ruinManiac = typeMedals.ruinManiac,
            hiker = typeMedals.hiker,
            bugCatcher = typeMedals.bugCatcher,
            hexManiac = typeMedals.hexManiac,
            depotAgent = typeMedals.depotAgent,
            kindler = typeMedals.kindler,
            swimmer = typeMedals.swimmer,
            gardener = typeMedals.gardener,
            rocker = typeMedals.rocker
        )
    }
}