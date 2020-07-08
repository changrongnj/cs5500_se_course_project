class Day(object):
    
    def __init__(self, date: datetime.datetime, day_of_week: DayOfTheWeek, weather: Weather, visits: List[Visit]):

        self.date = date
        self.day_of_week = day_of_week
        self.weather = weather
        self.visits = visits
    
    def calculate_total_customers(self) -> int:
        return
    
    def calculare_customers_per_hour(self) -> dict:
        return
    
    def calculate_average_shopping_time(self) -> dict:
        return
    
    def get_peak_hour() -> int:
        return