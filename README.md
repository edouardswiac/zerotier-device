# zerotier-device [![Build Status](https://travis-ci.org/edouardswiac/zerotier-device.svg?branch=master)](https://travis-ci.org/edouardswiac/zerotier-device)

A java wrapper for zerotier-cli (https://www.zerotier.com/).
It implements join/leave network and info. It supports only unix/linux systems at the moment. A Windows implementation will follow.

## Installation

See releases. The artifact will be pushed to maven central soon.

## Usage

```java
ZeroTierDevice device = new ZeroTierDevice();
ZeroTierCli cli = device.getZeroTierCli(); // see platform implementations in cli package
cli.join("3d73jdhad");
cli.info();
cli.leave("3d73jdhad");
```

## Testing

There is one integration test (ZeroTierDeviceIT) that should pass if zerotier-cli is installed on your Unix/Linux machine.
Run the test with `mvn verify`

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## History

1.0.0 Initial release. Unix/Linux support

## Credits

Edouard Swiac <edouard.swiac@gmail.com>

## License

GPL
