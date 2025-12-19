import com.pratyush.football_score.data.model.StandingsResponseItem

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    data class Success(val items: List<StandingsResponseItem>) : HomeScreenState()
    data class Error(val message: String) : HomeScreenState()
}
