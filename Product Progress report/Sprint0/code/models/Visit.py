import datetime

class Visit:
    
    def __init__(self, visit_id: str, entry_time: datetime.datetime, leave_time: datetime.datetime, total_time: int):
        self.visit_id = visit_id
        self.entry_time = entry_time
        self.leave_time = leave_time
        self.total_time = total_time
        