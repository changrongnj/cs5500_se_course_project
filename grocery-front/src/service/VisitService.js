class VisitService {

    static instance = null;
    static getInstance() {
        if (VisitService.instance == null) {
            VisitService.instance = new VisitService();
        }
        return VisitService.instance;
    }

    createVisitUrl = "http://localhost:8080/visits/add/single";
    findAllVisitsUrl = "http://localhost:8080/visits/all/unordered";

    findAllVisits = () =>
        fetch(this.findAllVisitsUrl, {
            method: "GET",
            credentials: "include"
        })
            .then(res => res.json())
            .catch(err => alert(err.message));

    createVisit = visit =>
        fetch(this.createVisitUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(visit),
            credentials: "include"
        })
            .then(res => res.json())
            .catch(err => alert(err.message));

}

export default VisitService;
