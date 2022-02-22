package emlakburada.feign.client;


import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import emlakburada.dto.response.AdvertResponse;



@FeignClient(value = "emlakburada-banner",url="http://localhost:8081/")
public interface BannerFeignService {

	
	@GetMapping(value = "/banners")
	public default ResponseEntity<List<AdvertResponse>> getAllBanners(){
		return getAllBanners();
		
	}

	
	
	
	
}
