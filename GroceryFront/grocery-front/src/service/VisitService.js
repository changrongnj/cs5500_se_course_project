class VisitService {

    static instance = null;

    static getInstance() {
        if (VisitService.instance == null) {
            VisitService.instance = new VisitService();
        }
        return VisitService.instance;
    }

    search = request =>
        fetch(
            "127.0.0.1/8080/" +
            request.entity +
            "/type/" +
            request.type +
            "/page/" +
            request.page,
            {
                method: "GET",
                credentials: "include"
            }
        )
            .then(res => res.json())
            .catch(err => alert(err.message));

}

export default VisitService;
