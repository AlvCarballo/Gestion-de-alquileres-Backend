/**
 * 
 */
package es.deepcode.gestionalquileres.auth;

/**
 * @author Alvca
 *
 */
public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA ="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAwEwJpKOcMkNxSU4hl3uLhItpC9SdQIlH8G2FVonEIcbj8may\r\n"
			+ "XRTTJijmaCnI1xq3waD5q6FKCKhuQ0BOA14u9+C+YViBby/AKyZiBBCqnNJNDpZo\r\n"
			+ "JoWKBIrxJH2I6a3j4km7bHheSb0Tiq5vUN6854SzRPQqxgi2k3UgqgJulQEy4ohM\r\n"
			+ "RW/GDHPAUdsV3L8yroQcTB7PWZ0s66YzuDxnANiyzM/PUXHYCmnRwQxoWq3f9Y8a\r\n"
			+ "vk0PYdw9DVlbGd9LI3FTLCUW+6MIU+UY5CZhh39TAGKmrR7xSRGEo9qQoA+UvW1O\r\n"
			+ "o9HUV4Y+eYM655//dbSakuJJTf1oobz/qwZMrwIDAQABAoIBAQCpdRh2Xruxy58U\r\n"
			+ "g2a00GmldxkuFMIy8gdUR59eIG+XeGa94WRDBKwCD77jghb8AA548ruyVKMiOBNa\r\n"
			+ "7lsROrlXNVVwAYemjMTjAaMUg/9lzSmctky3zaxPzoUsq/ewPc35RxKERxqIDrge\r\n"
			+ "2RM9h9uehmFYXXcoJtuF3IzZZOVAJlCkpKK9gYLmFJZ+sF05P8vvwWgI7KU3RNgG\r\n"
			+ "AKqaSfkVVmFZT2+Hsc39gO2ImVrpKBWijZxkTVyjvGfDvtb3C9sYCBOBKSQSkViV\r\n"
			+ "yCpJU/U+jh2R5dFJqBYjIwHX8auRUJvgFzg0H1vTkxuDvS+zzcgK6D6znPcYI4Hy\r\n"
			+ "ISFjyF4JAoGBAP4VELPjubkYk2+AZteyVFP6Ljvaj3Ynrv6n0013EwP3Bq0UxZko\r\n"
			+ "VIZUdpLQwcH3KvfDs3CSaUJs1/cNhFr4cgWAW+NTf8M8lN7xbezufg3IVOqBvijX\r\n"
			+ "FX05qDIXx1II20zRL5YKxTn9+iGpFoGv13IpI/HitkEJqWqaxUj4+gRDAoGBAMG/\r\n"
			+ "l3gIC8SNHIoyp3+JNuaGkQ3GaVr6M92NFp+ewUQnkgd+S+QiKsPOahlP0hDWRxNk\r\n"
			+ "ikW0koO6nJPoQ+lg0JggBtMOp7BPhMQUbxPNxXJ+cC6qgImO8tNTfyB4tOEpz0At\r\n"
			+ "A+nP8OB2LaAXwa2Yccq/AssGNivNnBJSU74RQiUlAoGAfeRCGl/DLgsXQjAExOr/\r\n"
			+ "DXzwW4e3fXu8IUFWWROewGAtVqTsIy7wcn53Idd9qXWmPI0i46wnq1nyx95SriBb\r\n"
			+ "no4y+TfuHfZubOiC5tpkar/QE0GlzuaDJ0DiLa/KesMYpb8gLN+5STqmLPdyx18x\r\n"
			+ "CMeJn9gNJbx7zO5Swg1bE7ECgYAgRKuSdyyWkLX3IlaZPB4jqLfR5oC3gUJQHOZu\r\n"
			+ "sT8Y/copa1Rya2pZ8C/lhVDEMxvlU/Jfh6J7RAI99AoTfWdgXr0kO6WcDLJdAdY6\r\n"
			+ "IyRGXF6MtyLvRhqVLavXmaLueUsmMhkbwOEqUSRqLGq6YdBZ5xQtAhzVkMn0lzeR\r\n"
			+ "SUiN7QKBgQCfklK2oo5YBZPXRWms9sdoi3JDQky0xx3LDD0CS4TAuBRjgm6dWqpK\r\n"
			+ "Qm1kjt8XdyZuezi7MJg6zLCRGugcdkexsVlC25zG3yfQtFCIXVbH7L/jVMymikEP\r\n"
			+ "t4KBNp9b/xs1u4tyPnMSwPmxrFvy7TGU4IwICREBvo0twOFje2CdRw==\r\n"
			+ "-----END RSA PRIVATE KEY-----";	
	
	public static final String RSA_PUBLICA ="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwEwJpKOcMkNxSU4hl3uL\r\n"
			+ "hItpC9SdQIlH8G2FVonEIcbj8mayXRTTJijmaCnI1xq3waD5q6FKCKhuQ0BOA14u\r\n"
			+ "9+C+YViBby/AKyZiBBCqnNJNDpZoJoWKBIrxJH2I6a3j4km7bHheSb0Tiq5vUN68\r\n"
			+ "54SzRPQqxgi2k3UgqgJulQEy4ohMRW/GDHPAUdsV3L8yroQcTB7PWZ0s66YzuDxn\r\n"
			+ "ANiyzM/PUXHYCmnRwQxoWq3f9Y8avk0PYdw9DVlbGd9LI3FTLCUW+6MIU+UY5CZh\r\n"
			+ "h39TAGKmrR7xSRGEo9qQoA+UvW1Oo9HUV4Y+eYM655//dbSakuJJTf1oobz/qwZM\r\n"
			+ "rwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
