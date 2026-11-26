<h1 align="center">CropsNH Extension</h1>
<p align="center"><strong><em>GTNH社区mod</em></strong></p>

> [!NOTE]
> 这是一个非官方mod，讨论此mod时请注意场合。
> **GTNH新手群严禁私货内容讨论。**
> 
fork from https://github.com/ny3a/cropsNH-extension

A GTNH addon that adds endgame mineral crops to CropsNH.

## 📥 Downloads & Compatibility

| GTNH Version | Mod Version |      Status       | Download                                                                                                                         |
|:------------:|:-----------:|:-----------------:|:---------------------------------------------------------------------------------------------------------------------------------|
|  **2.9.2**   |  `1.0.4`   | ✅ **Recommended** | [Latest](https://github.com/ramify-ame/cropsNH-extension/releases/tag/1.0.4)                                                    |
|  **2.9.1**   |  `1.0.3`   | ✅ **Recommended** | [1.0.3](https://github.com/ramify-ame/cropsNH-extension/releases/tag/1.0.3)                                                    |
|  **2.9.0**   |  `1.0.2`   | ✅ **Recommended** | [1.0.2](https://github.com/ramify-ame/cropsNH-extension/releases/tag/1.0.2)                                                     |
|  **<2.9.0**  |   None      | ❌     EOL         | None                                                                                                                             |


### Features

- 7 brand-new endgame crops
- Configurable growth points
- Todo: Large Generating Seed Machine

### Requirements

- GTNH 2.9.2 (Minecraft 1.7.10, Forge)
- CropsNH 2.0.142
- GregTech 5.09.54.277

### Configuration

Config file: `config/cropsnhext.cfg` (auto-generated on first launch).

The `debug` category lets you override the **growth points** (tick duration) of each crop without touching code:

```ini
debug {
    # Growth points (tick duration) for each custom crop.
    I:neutronium=20000
    I:cosmicNeutronium=200000
    I:infinity=200000
    I:infinityCatalyst=20000
    I:draconium=20000
    I:awakenedDraconium=20000
    I:bedrockium=20000
}
```

Higher values grow slower. Restart the game to apply.

### Building (JDK 25)

```bash
./gradlew build
```

The output jar is at `build/libs/cropsnhext-<version>.jar`. Drop it into the `mods/` folder.

### License

Apache License 2.0

---

一个 GTNH 附属模组，为 CropsNH 添加终局矿物作物。

### 功能

- 7 个全新终局作物
- 可配置生长点数
- Todo：大型种子生成机

### 前置要求

- GTNH 2.9.2 (Minecraft 1.7.10, Forge)
- CropsNH 2.0.142
- GregTech 5.09.54.277

### 配置

配置文件：`config/cropsnhext.cfg`（首次启动自动生成）。

`debug` 分类可单独调整每个作物的**生长点数**（tick），无需改代码：

```ini
debug {
    # Growth points (tick duration) for each custom crop.
    I:neutronium=20000
    I:cosmicNeutronium=200000
    I:infinity=200000
    I:infinityCatalyst=20000
    I:draconium=20000
    I:awakenedDraconium=20000
    I:bedrockium=20000
}
```

数值越大生长越慢。改完重启游戏生效。

### 构建（JDK 25）

```bash
./gradlew build
```

产物在 `build/libs/cropsnhext-<version>.jar`。将 jar 放入 `mods/` 文件夹即可。

### 许可

Apache License 2.0

