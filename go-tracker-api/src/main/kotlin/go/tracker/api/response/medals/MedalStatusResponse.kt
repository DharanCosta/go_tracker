package go.tracker.api.response.medals

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import go.tracker.models.trainer.medals.FiniteMedalsValues
import go.tracker.models.trainer.medals.MedalsValues
import go.tracker.models.trainer.medals.RegionsValues
import go.tracker.models.trainer.medals.TypeMedalsValues

@JsonInclude(Include.NON_NULL)
data class MedalStatusResponse (
    val jogger: Long? = null,
    val collector: Long? = null,
    val scientist: Long? = null,
    val breeder: Long? = null,
    val backpacker: Long? = null,
    val battleGirl: Long? = null,
    val gymLeader: Long? = null,
    val berryMaster: Long? = null,
    val champion: Long? = null,
    val legendaryPokemon: Long? = null,
    val pokemonRanger: Long? = null,
    val idol: Long? = null,
    val gentleman: Long? = null,
    val pilot: Long? = null,
    val fisher: Long? = null,
    val aceTrainer: Long? = null,
    val youngster: Long? = null,
    val pikachuFan: Long? = null,
    val greatLeagueVeteran: Long? = null,
    val ultraLeagueVeteran: Long? = null,
    val masterLeagueVeteran: Long? = null,
    val cameraman: Long? = null,
    val hero: Long? = null,
    val ultraHero: Long? = null,
    val purifier: Long? = null,
    val successor: Long? = null,
    val risingStar: Long? = null,
    val risingStarDuo: Long? = null,
    val triathlete: Long? = null,
    val tinyPokemonCollector: Long? = null,
    val jumboPokemonCollector: Long? = null,
    val picnicker: Long? = null,
    val friendFinder: Long? = null,
    val showcase: Long? = null,
    val routes: Long? = null,
    val wayfarer: Long? = null,
    val eliteCollector: Long? = null,
    val events: Long? = null,

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