package emlakburada.feign.rest;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.client.BannerClient;
import emlakburada.model.Advert;

@RestController
@RequestMapping("/banners")
public class BannerFeignController {
	

	
	@GetMapping("/banners")
	public BannerClient showBanner(@PathVariable Advert advert) {
		return showBanner(advert);
	}
	
	
	
	
	

}
