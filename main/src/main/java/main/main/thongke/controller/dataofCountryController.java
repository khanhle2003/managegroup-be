package main.main.thongke.controller;

    import java.util.List;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

import main.main.thongke.service.dataofCountryService;
    
    @RestController
    @RequestMapping("/api/data")
    public class dataofCountryController {
        
        @Autowired
        private dataofCountryService dataService;
        
        @GetMapping("/countries")
        public List<String> getDistinctCountries() {
            return dataService.getAllDistinctCountries();
        }
        @GetMapping("/invitation")
        public List<String> getDistinctInvitationUnits() {
            return dataService.getAllDistinctInvitationUnits();
        }
}
