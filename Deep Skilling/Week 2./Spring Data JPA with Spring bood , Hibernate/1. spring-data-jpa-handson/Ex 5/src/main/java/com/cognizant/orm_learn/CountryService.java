@Transactional
public List<Country> getAllCountries() {

    return countryRepository.findAll();

}