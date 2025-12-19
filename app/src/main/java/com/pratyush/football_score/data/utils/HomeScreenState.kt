import com.pratyush.football_score.data.model.StandingsResponseItem
import com.pratyush.football_score.data.model.Stats

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    data class Success(
        val items: List<StandingsResponseItem>
    ) : HomeScreenState()
    data class Error(val message: String) : HomeScreenState()
}
