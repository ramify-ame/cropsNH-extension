# CropsNH Extension


A GTNH addon that adds endgame mineral crops to CropsNH. Grow intermediate **flower** items, then process them into dust, ingots and molten metals in GregTech machines.

### Features

- 7 brand-new endgame crops (magic seed shape, enchanted seeds, machine-only growth, modeled on the SpaceFlower)
- Configurable growth points (debug config file)
- Todo: Large Generating Seed Machine

### Requirements

- GTNH 2.9+ (Minecraft 1.7.10, Forge)
- CropsNH 2.0.91+
- GregTech 5.09.54.20+

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

### Items & Blocks

- 7 flower items (flowerNeutronium etc.) — crop products, crafted/processed into materials
- **Infinity Catalyst Block** (`blockInfinityCatalyst`) — compressed from 9 ingots, also one of the soil blocks for the Infinity Catalyst crop

### Building

```bash
./gradlew build
```

The output jar is at `build/libs/cropsnhext-<version>.jar`. Drop it into the `mods/` folder.

### License

Apache License 2.0

---

一个 GTNH 附属模组，为 CropsNH 添加终局矿物作物。种植中间产物——**花**，再在 GT 机器中加工成粉、锭和熔融金属。

### 功能

- 7 个全新终局作物（魔种子形状、附魔种子、机器专属种植，仿空间之花模板）
- 可配置生长点数（debug 配置文件）
- Todo：大型种子生成机

### 前置要求

- GTNH 2.9+ (Minecraft 1.7.10, Forge)
- CropsNH 2.0.91+
- GregTech 5.09.54.20+

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

### 物品与方块

- 7 种花物品（flowerNeutronium 等）——作物产物，合成/加工成材料
- **无尽催化剂块**（`blockInfinityCatalyst`）——9 锭压缩而成，同时是无尽催化剂花的垫底方块之一

### 构建

```bash
./gradlew build
```

产物在 `build/libs/cropsnhext-<version>.jar`。将 jar 放入 `mods/` 文件夹即可。

### 许可

Apache License 2.0
